const std = @import("std");
const toUpper = std.ascii.toUpper;

pub fn score(s: []const u8) u32 {
    var count: u32 = 0;

    for (s) |value| {
        count += scrabble(toUpper(value));
    }

    return count;
}

pub fn scrabble(c: u8) u32 {
    return switch (c) {
        'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T' => 1,
        'D', 'G' => 2,
        'B', 'C', 'M', 'P' => 3,
        'F', 'H', 'V', 'W', 'Y' => 4,
        'K' => 5,
        'J', 'X' => 8,
        'Q', 'Z' => 10,
        else => 0,
    };
}
