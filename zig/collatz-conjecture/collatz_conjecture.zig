// Please implement the `ComputationError.IllegalArgument` error.

pub fn steps(number: usize) anyerror!usize {
    return switch (number) {
        0 => ComputationError.IllegalArgument,
        1 => 0,
        else => 1 + try steps(collatzConjecture(number)),
    };
}

pub fn collatzConjecture(number: usize) usize {
    if (number % 2 == 0) return number / 2;
    return (3 * number) + 1;
}

pub const ComputationError = error{IllegalArgument};
