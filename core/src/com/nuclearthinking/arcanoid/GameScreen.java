package com.nuclearthinking.arcanoid;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.nuclearthinking.arcanoid.objects.Ball;
import com.nuclearthinking.arcanoid.objects.Platform;
import com.nuclearthinking.arcanoid.objects.Wall;

import static com.nuclearthinking.arcanoid.Vars.PPM;

/**
 * Date: 12.03.2016
 * Time: 18:21
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */
public class GameScreen implements Screen {
    private final Arcanoid mainGame;
    private final Resources resources;
    private final Color backgroundColor;
    private OrthographicCamera camera;
    private final Texture topMenu, arcanoid, hearth, ballTexture;
    private final Wall gameWall;
    World world;
    Ball ball;
    Platform platform;
    Box2DDebugRenderer box2DDebugRenderer = new Box2DDebugRenderer();
    Controller controller;

    public GameScreen(final Arcanoid mainGame) {
        this.mainGame = mainGame;
        world = new World(new Vector2(0, 0), true);
        controller = new Controller(world);
        world.setContactListener(new ContactsListener());
        resources = Resources.getInstance();
        backgroundColor = ColorPalette.BACKGROUND;


        //TODO Создать VIEW для них
        ballTexture = resources.getTexture("ball");
        topMenu = resources.getTexture("topmenu");
        arcanoid = resources.getTexture("arcanoid");
        hearth = resources.getTexture("hearth");
        gameWall = controller.getWall();

        //TODO Перенести в контроллер
        platform = controller.getPlatform();
        ball = controller.getBall();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Vars.WIDTH / PPM, Vars.HEIGHT / PPM);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

//        int hearthXPos = Vars.WIDTH - (16 + 5);
//        Gdx.gl.glClearColor(backgroundColor.r, backgroundColor.g, backgroundColor.b, 1);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        controller.update();
//        camera.update();

        /*
        mainGame.batch.setProjectionMatrix(camera.combined);
        mainGame.batch.begin();
        mainGame.batch.draw(ballTexture, ball.getBody().getPosition().x - 16 / 2, ball.getBody().getPosition().y - 16 / 2);
        mainGame.batch.draw(topMenu, 0, Vars.HEIGHT - Vars.TOPMENU_HEIGHT);
        mainGame.batch.draw(arcanoid, platform.getPosition().x - Vars.ARCANOID_WIDTH / 2, platform.getPosition().y - Vars.ARCANOID_HEIGHT / 2);
        for (int i = 0; i < GameState.getInstance().getLifeAmount(); i++) {
            mainGame.batch.draw(hearth, hearthXPos, Vars.HEIGHT - 25);
            hearthXPos -= 20;
        }
        for (List<Brick> wallRow : gameWall.getWallArray()) {
            for (Brick brick : wallRow) {
                mainGame.batch.draw(brick.getTexture(), brick.getPosition().x - 40, brick.getPosition().y - 10);
            }
        }
        FontFactory.getFont10().draw(mainGame.batch, GameState.getInstance().getScoreString(), 20, 445);
        mainGame.batch.end();
        */

//        if (Vars.DEBUG) {
        world.step(Gdx.graphics.getDeltaTime(), 6, 2);

        box2DDebugRenderer.render(world, camera.combined);
//        }
    }


    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
