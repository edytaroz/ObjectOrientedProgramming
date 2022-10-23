package agh.ics.oop;

public enum MapDirection {
        NORTH,
        SOUTH,
        WEST,
        EAST;
    @Override
    public String toString() {
        switch (this) {
            case EAST:
                return "Wschód";
            case WEST:
                return "Zachód";
            case NORTH:
                return "Północ";
            case SOUTH:
                return "Południe";
            default:
                return "Coś nie tak";
        }
    }
    public MapDirection next () {
        switch (this) {
            case EAST: return MapDirection.SOUTH;
            case SOUTH: return MapDirection.WEST;
            case WEST: return MapDirection.NORTH;
            case NORTH: return MapDirection.EAST;
            default:
                System.out.println("Coś nie tak");
                return null;
        }
    }
    public MapDirection previous () {
        switch (this) {
            case EAST: return MapDirection.NORTH;
            case SOUTH: return MapDirection.EAST;
            case WEST: return MapDirection.SOUTH;
            case NORTH: return MapDirection.WEST;
            default:
                System.out.println("Coś nie tak");
                return null;
        }
    }
    public Vector2d toUnitVector () {
        switch (this) {
            case EAST: return new Vector2d(1,0);
            case SOUTH: return new Vector2d(0,-1);
            case WEST: return new Vector2d(-1,0);
            case NORTH: return new Vector2d(0,1);
            default:
                System.out.println("Coś nie tak");
                return null;
        }
    }
}
