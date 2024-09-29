const mem = @import("std").mem;

pub fn rotate(allocator: mem.Allocator, text: []const u8, shiftKey: u5) mem.Allocator.Error![]u8 {
    const buffer = try allocator.alloc(u8, text.len);

    for (text, buffer) |val, *out| {
        const rotated = switch (val) {
            'a'...'z' => ((val - 'a' + shiftKey) % 26) + 'a',
            'A'...'Z' => ((val - 'A' + shiftKey) % 26) + 'A',
            else => val,
        };

        out.* = rotated;
    }

    return buffer;
}
