package com.nuclearthinking.arcanoid.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.nuclearthinking.arcanoid.BrickType;
import com.nuclearthinking.arcanoid.Resources;

import static com.nuclearthinking.arcanoid.Vars.BRICK_HEIGHT;
import static com.nuclearthinking.arcanoid.Vars.BRICK_WIDTH;

/**
 * Date: 20.03.2016
 * Time: 21:42
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */
public class Brick {


    private final Resources resources;
    private final Texture texture;
    Body body;


    public Brick(final BrickType brickType, Body body) {
        this.body = body;
        resources = Resources.getInstance();
        texture = textureChooser(brickType);
        createBrickBody();
        body.setUserData(this);
    }

    private void createBrickBody() {
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BRICK_WIDTH / 2, BRICK_HEIGHT / 2);
        Fixture brickFixture = body.createFixture(shape, 1);
        brickFixture.setFriction(1);
        shape.dispose();
    }


    private Texture textureChooser(final BrickType brickType) {
        switch (brickType) {
            case BRICK1:
                return resources.getTexture("brick1");
            case BRICK2:
                return resources.getTexture("brick2");
            case BRICK3:
                return resources.getTexture("brick3");
            case BRICK4:
                return resources.getTexture("brick4");
            case BRICK5:
                return resources.getTexture("brick5");
            case BRICK6:
                return resources.getTexture("brick6");

        }

        return resources.getTexture("brick1");
    }


    public Texture getTexture() {
        return texture;
    }

    public Vector2 getPosition() {
        return body.getPosition();
    }

}