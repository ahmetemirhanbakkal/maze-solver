package src.algorithm;

import java.util.List;

import src.Tile;

public class BreadthFirstSearch extends Search {
    @Override
    public void search() {
        while (!frontier.isEmpty()) {
            Tile currentTile = frontier.remove(0);

            exploredTiles.add(currentTile);
            expandedCoordinates.add(currentTile.getRealCoordinates());

            if (maze.get(currentTile) == 'G') {
                lastTile = currentTile;
                findSolution();
                break;
            }

            List<Tile> expandableTiles = getExpandableTiles(currentTile);

            for (Tile tile : expandableTiles) {
                if (!frontier.contains(tile) && !exploredTiles.contains(tile)) {
                    frontier.add(tile);
                }
            }
        }
    }
}