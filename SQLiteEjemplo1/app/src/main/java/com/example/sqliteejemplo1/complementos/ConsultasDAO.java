package com.example.sqliteejemplo1.complementos;

import android.content.Context;

import com.example.sqliteejemplo1.basededatos.BebidaVO;

public interface ConsultasDAO {

    public boolean insertarBebida(BebidaVO bvo, Context context);

}
