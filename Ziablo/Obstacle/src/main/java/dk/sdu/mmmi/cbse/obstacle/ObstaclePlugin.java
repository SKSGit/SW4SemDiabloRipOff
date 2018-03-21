/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.obstacle;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Sadik
 */

@ServiceProvider(service = IGamePluginService.class)
public class ObstaclePlugin implements IGamePluginService {

    private Entity obstacle;

    private Entity createObstacle(GameData gameData) {

        float deacceleration = 0;
        float acceleration = 0;
        float maxSpeed = 0;
        float rotationSpeed = 0;
        float x = gameData.getDisplayWidth() / 5;
        float y = gameData.getDisplayHeight() / 5;
        float radians = 3.1415f / 2;
        int life = Integer.MAX_VALUE;
        float lifeExpiration = Float.MAX_VALUE;
        
        
        Entity obstacle = new Obstacle();
        obstacle.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        obstacle.add(new PositionPart(x, y, radians));
        obstacle.add(new LifePart(life, lifeExpiration));
        obstacle.setRadius(8);

        return obstacle;
    }

    @Override
    public void start(GameData gameData, World world) {
        // Add entities to the world
        obstacle = createObstacle(gameData);
        world.addEntity(obstacle);
        System.out.println("dk.sdu.mmmi.cbse.enemy.ObstaclePlugin.start()");
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(obstacle);
        System.out.println("dk.sdu.mmmi.cbse.enemy.ObstaclePlugin.stop()");
    }
}
