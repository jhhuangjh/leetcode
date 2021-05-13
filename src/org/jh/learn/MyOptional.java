package org.jh.learn;

import java.lang.invoke.MutableCallSite;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author hjh
 * @version 1.0
 * @date 2021/5/13 20:26
 */
public final class MyOptional<T> {
    private final T value;
    private static final MyOptional<?> EMPTY = new MyOptional<>();

    public MyOptional() {
        this.value = null;
    }

    public MyOptional(T value) {
        this.value = Objects.requireNonNull(value);
    }

    public static <T> MyOptional<T> empty() {
        @SuppressWarnings("unchecked")
        MyOptional<T> t = (MyOptional<T>) EMPTY;
        return t;
    }

    public T get() {
        if (value == null) {
            throw new NoSuchElementException("no value present");
        }
        return value;
    }

    public static <T> MyOptional<T> of(T value) {
        return new MyOptional<>(value);
    }

    public static <T> MyOptional<T> ofNullable(T value) {
       return value == null ? empty() : of(value);
    }

    public boolean isPresent() {
        return value != null;
    }

    public void ifPresent(Consumer<? super T> consumer) {
        if (value != null) {
            consumer.accept(value);
        }
    }

    public <U> MyOptional<U> map(Function<? super T, ? extends U> mapper) {
        Objects.requireNonNull(mapper);
        if (!isPresent()) {
            return empty();
        } else {
            return MyOptional.ofNullable(mapper.apply(value));
        }
    }

    public <U> MyOptional<U> flatMap(Function<? super T, MyOptional<U>> mapper) {
        Objects.requireNonNull(mapper);
        if (!isPresent()) {
            return empty();
        } else {
            return Objects.requireNonNull(mapper.apply(value));
        }
    }

    public MyOptional<T> filter (Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        if (!isPresent()) {
            return this;
        } else {
            return predicate.test(value) ? this : empty();
        }
    }

    public T orElse(T other) {
        return value == null ? other : value;
    }

    public T orElseGet(Supplier<? extends T> supplier) {
        return value == null ? supplier.get() : value;
    }

    public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
        if (value != null) {
            return value;
        } else {
            throw exceptionSupplier.get();
        }
    }
}
