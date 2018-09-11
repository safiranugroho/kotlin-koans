package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int = when {
        this.year != other.year -> this.year - other.year
		this.month != other.month -> this.month - other.month
		else -> this.dayOfMonth - other.dayOfMonth
    }

    operator fun inc(): MyDate = this.nextDay()
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)
operator fun MyDate.plus(timeInterval: TimeInterval): MyDate = this.addTimeIntervals(timeInterval, 1)
operator fun MyDate.plus(timeInterval: RepeatedTimeInterval): MyDate = this.addTimeIntervals(timeInterval.timeInterval, timeInterval.number)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

operator fun TimeInterval.times(number: Int): RepeatedTimeInterval = RepeatedTimeInterval(this, number)
data class RepeatedTimeInterval(val timeInterval: TimeInterval, val number: Int) {}

class DateRange(override val start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>, Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return DateIterator(start, endInclusive)
    }
}

class DateIterator(val start: MyDate, val endInclusive: MyDate) : Iterator<MyDate> {
    private var current = start

    override fun hasNext(): Boolean {
        return current <= endInclusive
    }

    override fun next(): MyDate {
        return current++
    }
}