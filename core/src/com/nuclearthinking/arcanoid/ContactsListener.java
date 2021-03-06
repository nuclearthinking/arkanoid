package com.nuclearthinking.arcanoid;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.nuclearthinking.arcanoid.objects.Brick;
import com.nuclearthinking.arcanoid.objects.Platform;
import com.nuclearthinking.arcanoid.utils.DeleteQueue;
import com.nuclearthinking.arcanoid.utils.EntityDictionary;

/**
 * Date: 27.03.2016
 * Time: 19:21
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */
public class ContactsListener implements ContactListener {


    @Override
    public void beginContact(Contact contact) {


    }

    @Override
    public void endContact(Contact contact) {
        if (contact.getFixtureA().getBody().getUserData() instanceof Brick && contact.getFixtureB().getUserData() == EntityDictionary.BALL) {
            DeleteQueue.add(contact.getFixtureA().getBody());
        }
        if (contact.getFixtureA().getUserData() == EntityDictionary.BALL || contact.getFixtureB().getUserData() == EntityDictionary.BALL) {
            if (contact.getFixtureA().getUserData() == EntityDictionary.BALL) {
            }
        }

        if (contact.getFixtureA().getUserData() instanceof Platform && contact.getFixtureB().getUserData() == EntityDictionary.BALL) {

        }

        if (contact.getFixtureA().getUserData() == EntityDictionary.BALL && contact.getFixtureB().getUserData() instanceof Platform) {

        }
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
    }
}
