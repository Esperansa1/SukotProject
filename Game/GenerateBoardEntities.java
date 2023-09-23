package Game;

import java.util.ArrayList;

public class GenerateBoardEntities {

    private static ArrayList<Position> takenPositions = new ArrayList<Position>();

    public static void spawnEntities(ArrayList<BaseEntity> entities, PlayerHandler playerHandler) {
        generatePlayers(playerHandler, entities);
        generateTrees(entities);
        generateWeapons(entities);
    }

    private static void generatePlayers(PlayerHandler playerHandler, ArrayList<BaseEntity> entities){
        for (int i = 0; i < playerHandler.getPlayerAmount(); i++) {
            Position position =  generatePosition(entities);
            Player player = playerHandler.getNextPlayer();
            player.setPosition(position);

        }
    }

    private static void generateTrees(ArrayList<BaseEntity> entities){ // Partial CODE NEED TO BE FINISHED
        // Generate Trees ** ONLY FOR TESTING **
        for (int i = 0; i < 3; i++) {
            Position position =  generatePosition(entities);
            Tree tree = new Tree();
            tree.setPosition(position);

        }
    }

    private static void generateWeapons(ArrayList<BaseEntity> entities){ // Partial CODE NEED TO BE FINISHED
        for (int i = 0; i < 3; i++) {
            Position position =  generatePosition(entities);
            BaseWeapon weapon = new BaseWeapon("Weapon", "PEW");
            weapon.setPosition(position);
            entities.add(weapon);

        }
    }


    public static boolean isPositionTaken(Position position, ArrayList<BaseEntity> entities){
        for (int i = 0; i < entities.size(); i++) {
            if(entities.get(i).getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }


    public static Position generatePosition(ArrayList<BaseEntity> entities){
        Position generatedPosition;
        do {
            int xPos = (int)(Math.random() * 10);
            int yPos = (int)(Math.random() * 10);

            generatedPosition = new Position(xPos, yPos);

        }while(isPositionTaken(generatedPosition, entities));
        return generatedPosition;
    }





}
