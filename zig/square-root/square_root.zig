pub fn squareRoot(radicand: usize) usize {
    const float_radicand: f64 = @floatFromInt(radicand);
    const sqre_float: f64 = @sqrt(float_radicand);
    return @intFromFloat(sqre_float);
}
