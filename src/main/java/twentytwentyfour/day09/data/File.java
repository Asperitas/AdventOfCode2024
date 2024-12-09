package twentytwentyfour.day09.data;

public record File(int id, int index, int size) {
    public String getContents() {
        return String.valueOf(id);
    }
}
