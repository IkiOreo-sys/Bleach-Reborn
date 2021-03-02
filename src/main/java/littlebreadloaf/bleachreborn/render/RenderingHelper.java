package littlebreadloaf.bleachreborn.render;

import net.minecraft.entity.monster.*;
import org.lwjgl.opengl.*;
import org.lwjgl.util.glu.*;
import net.minecraft.entity.player.*;
import java.awt.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.client.renderer.entity.*;

public class RenderingHelper
{
    public static void drawCeroSphere(final double x, final double y, final double z, final float r, final int slices, final int stacks, final EntityMob entity) {
        GL11.glPushMatrix();
        GL11.glTranslated(x, y, z);
        GL11.glTranslated(2.0, 0.0, 0.0);
        GL11.glDisable(2884);
        GL11.glDisable(2896);
        GL11.glColor3f(1.0f, 0.0f, 0.0f);
        new Sphere().draw(r, 10, 10);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        GL11.glEnable(2884);
        GL11.glEnable(2896);
        GL11.glPopMatrix();
    }
    
    public static Color getColorFromPlayer(final EntityPlayer entity) {
        Color color = new Color(0);
        if (entity == null) {
            return color;
        }
        final ExtendedPlayer props = (ExtendedPlayer)entity.getExtendedProperties("BleachPlayer");
        switch (props.getZType()) {
            case 0: {
                color = Color.RED;
                break;
            }
            case 1: {
                color = Color.GREEN;
                break;
            }
            case 2: {
                color = Color.BLUE;
                break;
            }
        }
        return color;
    }
    
    public static void renderBeam(final float x, final float y, final float z, final float i, final float j, final float k) {
        final float height = 0.1f;
        final float dist;
        final float repeat = dist = (float)Math.sqrt((x - i) * (x - i) + (y - j) * (y - j) + (z - k) * (z - k));
        GL11.glTexCoord2f(0.0f, 0.0f);
        GL11.glVertex3f(x, y - 0.1f, z);
        GL11.glTexCoord2f(0.0f, 1.0f);
        GL11.glVertex3f(x, y + 0.1f, z);
        GL11.glTexCoord2f(1.0f * repeat, 1.0f);
        GL11.glVertex3d((double)i, (double)(j + 0.3f + 0.1f), (double)k);
        GL11.glTexCoord2f(1.0f * repeat, 0.0f);
        GL11.glVertex3d((double)i, (double)(j + 0.3f - 0.1f), (double)k);
    }
    
    public static void renderBeam(final float x, final float y, final float z, final double i, final double j, final double k) {
        renderBeam(x, y, z, (float)i, (float)j, (float)k);
    }
    
    public static void renderFacingQuad(final double x, final double y, final double z, final float scale) {
        GL11.glPushMatrix();
        GL11.glTranslated(x, y, z);
        applyFloatingRotations();
        GL11.glScaled((double)(0.1f * scale), (double)(0.1f * scale), 1.0);
        final int h = 1;
        final int w = 1;
        GL11.glBegin(7);
        GL11.glTexCoord2f(0.0f, 1.0f);
        GL11.glVertex3f(-1.0f, -1.0f, 0.001f);
        GL11.glTexCoord2f(0.0f, 0.0f);
        GL11.glVertex3f(-1.0f, 1.0f, 0.001f);
        GL11.glTexCoord2f(1.0f, 0.0f);
        GL11.glVertex3f(1.0f, 1.0f, 0.001f);
        GL11.glTexCoord2f(1.0f, 1.0f);
        GL11.glVertex3f(1.0f, -1.0f, 0.001f);
        GL11.glEnd();
        GL11.glPopMatrix();
    }
    
    private static void applyFloatingRotations() {
        GL11.glRotatef(-RenderManager.instance.playerViewY, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(RenderManager.instance.playerViewX, 1.0f, 0.0f, 0.0f);
    }
}
