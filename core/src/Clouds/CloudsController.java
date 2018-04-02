package Clouds;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import helpers.GameInfo;

/**
 * Created by gagan on 02/04/2018.
 */

public class CloudsController {

    private World world;
    private Array<Cloud> clouds = new Array<Cloud>();

    private final float DISTANCE_BETWEEN_CLOUDS = 250f;
    private float minX, maxX;
    public CloudsController(World world) {
        this.world = world;
        minX = GameInfo.WIDTH/2f-110;
        minX = GameInfo.WIDTH/2f+110;
        createClouds();
        positionClouds();
    }

    private void createClouds() {

        for(int i = 0; i < 2; i ++) {
            clouds.add(new Cloud(world, "Dark Cloud"));
        }

        int index = 1;
        for(int i = 0; i < 6; i ++) {
            clouds.add(new Cloud(world,"Cloud " + index));
            index++;
            if(index == 4)
                index = 1;
        }

        clouds.shuffle();



    }

    private void positionClouds() {

        // first cloud must not be a "dark cloud"
        while (clouds.get(0).getCloudName()==("Dark Cloud")) {
            clouds.shuffle();
        }
        float positionY = GameInfo.HEIGHT / 2f;
        float tempX = GameInfo.WIDTH / 2f;
        for (Cloud c : clouds) {
            c.setSpritePosition(tempX, positionY);
            positionY -= DISTANCE_BETWEEN_CLOUDS;
        }
    }

    public void drawClouds(SpriteBatch batch) {
        for(Cloud cloud : clouds) {
            batch.draw(cloud, cloud.getX() - cloud.getWidth() / 2f, cloud.getY() - cloud.getHeight() / 2f);
        }
    }



}
