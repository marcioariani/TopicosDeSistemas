package com.example.marcio.tb001androidmenu.app;

import android.app.AlertDialog;
import android.content.Context;

/**
 * Created by marcio on 28/11/2015.
 */
public class MessageBox {

    public static void showInfo(Context ctx, String tittle, String msg){

        show(ctx, tittle, msg, android.R.drawable.ic_dialog_info);

    }

    public static void showAlert(Context ctx, String tittle, String msg){

        show(ctx, tittle, msg, android.R.drawable.ic_dialog_alert);

    }

    public static void show(Context ctx, String tittle, String msg){

        show(ctx, tittle, msg, 0);

    }

    public static void show(Context ctx, String tittle, String msg, int iconId){

        AlertDialog.Builder dlg = new AlertDialog.Builder(ctx);
        dlg.setIcon(iconId);
        dlg.setTitle(tittle);
        dlg.setMessage(msg);
        dlg.setNeutralButton("OK", null);
        dlg.show();

    }

}
