const std = @import("std");

pub fn isIsogram(str: []const u8) bool {
    const alloc = std.heap.page_allocator;

    var set: std.DynamicBitSet = std.DynamicBitSet.initEmpty(alloc, str.len) catch return false;

    for (str) |c| {
        if (!isLetter(c)) continue;
        if (set.isSet(toLower(c))) return false;
        set.put(toLower(c));
    }

    return true;
}

fn isLetter(c: u8) bool {
    if (c >= 'A' and c <= 'Z') return true;
    if (c >= 'a' and c <= 'z') return true;
    return false;
}

fn toLower(c: u8) u8 {
    if (c >= 'A' and c <= 'Z') return c + ('a' - 'A');
    return c;
}
