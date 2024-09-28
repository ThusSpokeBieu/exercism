const std = @import("std");

pub fn isArmstrongNumber(num: u128) bool {
    const num_digits = countDigits(num);
    var temp = num;
    var sum: u128 = 0;

    while (temp != 0) {
        const digit = temp % 10;
        sum += std.math.pow(u128, digit, num_digits);
        temp /= 10;
    }
    return num == sum;
}

fn countDigits(num: u128) u32 {
    var count: u32 = 0;
    var temp = num;
    while (temp != 0) {
        count += 1;
        temp /= 10;
    }
    return count;
}
