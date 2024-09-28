pub fn squareOfSum(number: usize) usize {
    var count: usize = 0;
    for (1..number + 1) |i| {
        count += i;
    }

    return count * count;
}

pub fn sumOfSquares(number: usize) usize {
    var count: usize = 0;
    for (1..number + 1) |i| {
        count += i * i;
    }

    return count;
}

pub fn differenceOfSquares(number: usize) usize {
    return squareOfSum(number) - sumOfSquares(number);
}
