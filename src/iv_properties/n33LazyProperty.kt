package iv_properties

import util.TODO

class LazyProperty(val initializer: () -> Int) {
    data class Number(var value: Int)
    lateinit var initialized: Number

    val lazy: Int
        get() {
            if (!this::initialized.isInitialized) {
                initialized = Number(initializer())
            }
            return initialized.value
        }
}

fun todoTask33(): Nothing = TODO(
    """
        Task 33.
        Add a custom getter to make the 'lazy' val really lazy.
        It should be initialized by the invocation of 'initializer()'
        at the moment of the first access.
        You can add as many additional properties as you need.
        Do not use delegated properties yet!
    """,
    references = { LazyProperty({ 42 }).lazy }
)
