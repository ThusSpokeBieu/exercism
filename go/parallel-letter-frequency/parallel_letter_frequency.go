package letter

import "sync"

// FreqMap records the frequency of each rune in a given text.
type FreqMap map[rune]int

// Frequency counts the frequency of each rune in a given text and returns this
// data as a FreqMap.
func Frequency(text string) FreqMap {
	frequencies := FreqMap{}
	for _, r := range text {
		frequencies[r]++
	}
	return frequencies
}

// ConcurrentFrequency counts the frequency of each rune in the given strings,
// by making use of concurrency.
func ConcurrentFrequency(texts []string) FreqMap {
	frequencies := FreqMap{}
	var wg sync.WaitGroup
	mu := &sync.Mutex{}

	for _, text := range texts {
		wg.Add(1)
		go func(text string) {
			defer wg.Done()
			localFreq := Frequency(text)
			mu.Lock()
			for r, count := range localFreq {
				frequencies[r] += count
			}
			mu.Unlock()
		}(text)
	}

	wg.Wait()
	return frequencies
}
