const std = @import("std");

pub fn isIsogram(str: []const u8) bool {
    var set: std.bit_set.IntegerBitSet(128) = std.bit_set.IntegerBitSet(128).initEmpty();

    for (str) |c| {
        if (!isLetter(c)) continue;

        const lower_c = toLower(c);

        if (set.isSet(lower_c)) return false;
        set.set(lower_c);
    }

    return true;
}

fn isLetter(c: u8) bool {
    return (c >= 'A' and c <= 'Z') or (c >= 'a' and c <= 'z');
}

fn toLower(c: u8) u8 {
    if (c >= 'A' and c <= 'Z') return c + ('a' - 'A');
    return c;
}
