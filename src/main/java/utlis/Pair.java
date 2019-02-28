package utlis;

import java.util.Objects;

public final class Pair<T1, T2> {
    private final T1 first;
    private final T2 second;

    public Pair(final T1 first, final T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Pair other = (Pair) obj;
        return Objects.equals(getFirst(), other.getFirst())
               && Objects.equals(getSecond(), other.getSecond());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirst(), getSecond());
    }
}
