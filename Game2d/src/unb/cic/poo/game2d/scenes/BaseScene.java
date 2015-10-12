package unb.cic.poo.game2d.scenes;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.Scene;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import android.app.Activity;
import unb.cic.poo.game2d.ResourceManager;
import unb.cic.poo.game2d.scenes.SceneManager.SceneType;

public abstract class BaseScene extends Scene {
    //---------------------------------------------
    // VARIABLES
    //---------------------------------------------	
    protected Engine engine;
    protected Activity activity;
    protected ResourceManager resourceManager;
    protected VertexBufferObjectManager vbom;
    protected Camera camera;
    
    //---------------------------------------------
    // CONSTRUCTOR
    //---------------------------------------------
    
    public BaseScene() {
        this.resourceManager = ResourceManager.getInstance();
        this.activity = resourceManager.activity;
		this.engine = resourceManager.engine;
        this.vbom = resourceManager.vbom;
        this.camera = resourceManager.camera;
        createScene();
    }
    
    //---------------------------------------------
    // ABSTRACTION
    //---------------------------------------------
    
    public abstract void createScene();
    
    public abstract void onBackKeyPressed();
    
    public abstract SceneType getSceneType();
    
    public abstract void disposeScene();
}