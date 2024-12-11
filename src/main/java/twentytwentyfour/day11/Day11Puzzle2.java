package twentytwentyfour.day11;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day11Puzzle2 extends Day11Puzzle1 {
    Map<StoneAtBlink, Long> map = new HashMap<>();

    public Day11Puzzle2(List<Long> stones) {
        super(stones);
    }

    @Override
    public long solve() {
        return stones.stream()
                .map(stone -> changeStoneAndCount(stone, 75))
                .reduce(0L, Long::sum);
    }

    private long changeStoneAndCount(long stone, int blinksToGo) {
        StoneAtBlink key = new StoneAtBlink(stone, blinksToGo);

        // If calculated before, don't calculate again.
        if (map.containsKey(key)) {
            return map.get(key);
        }

        List<Long> changedStones = changeStone(stone);

        // If this stone is at the last change return how many stones it has turned into
        if (blinksToGo == 1) {
            map.put(key, (long) changedStones.size());
            return changedStones.size();
        }

        // Otherwise sum up all the stones this one stone has changed into.
        long stoneCount = changedStones.stream()
                .map(changedStone -> changeStoneAndCount(changedStone, blinksToGo - 1))
                .reduce(0L, Long::sum);

        // Remember this, in case a similar stone at the same amount of blinks occurs.
        map.put(key, stoneCount);

        return stoneCount;
    }

    private record StoneAtBlink(long stone, int blinksToGo){}
}
