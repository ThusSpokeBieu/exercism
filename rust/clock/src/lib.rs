use std::fmt::Display;

#[derive(Debug, PartialEq)]
pub struct Clock {
    hours: i32,
    minutes: i32,
}

impl Clock {
    pub fn new(hours: i32, minutes: i32) -> Self {
        let clock = Clock {hours: 0,  minutes: 0 };
        clock.add_minutes(minutes + (hours * 60))
    }

    pub fn add_minutes(&self, minutes: i32) -> Self {
        let mut total_minutes = self.minutes + minutes;
        let mut total_hours = self.hours + total_minutes / 60;
        total_minutes %= 60;

        if total_minutes < 0 {
            total_minutes += 60;
            total_hours -= 1;
        }

        total_hours %= 24;
        if total_hours < 0 {
            total_hours += 24;
        }

        Clock {
            hours: total_hours,
            minutes: total_minutes,
        }
    }
}

impl Display for Clock {
    fn fmt(&self, f: &mut std::fmt::Formatter) -> std::fmt::Result {
        write!(f, "{:02}:{:02}", self.hours, self.minutes)
    }
}