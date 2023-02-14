package dollar;

import java.util.Objects;

class Pair {

    String from;
    String to;

    private Pair(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public static Pair of(String from, String to) {
        return new Pair(from, to);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return Objects.equals(from, pair.from) && Objects.equals(to, pair.to);
    }

    @Override
    public int hashCode() {
        return 0;
//        return Objects.hash(from, to);
    }
}
