package twentytwentyfour.day12.data;

import java.util.List;

public class RegionStats {
    private int area;
    private long boundaries;

    public RegionStats() {
        this.area = 0;
        this.boundaries = 0;
    }

    public RegionStats(int area, long boundaries) {
        this.area = area;
        this.boundaries = boundaries;
    }

    public int getArea() {
        return area;
    }

    public void addPlotToArea() {
        area++;
    }

    public long getBoundaries() {
        return boundaries;
    }

    public void addBoundaries(long boundaries) {
        this.boundaries += boundaries;
    }

    public static RegionStats of(List<RegionStats> list) {
        int area = 0;
        long boundaries = 0;

        for (RegionStats stats : list) {
            area += stats.getArea();
            boundaries += stats.getBoundaries();
        }

        return new RegionStats(area, boundaries);
    }
}
