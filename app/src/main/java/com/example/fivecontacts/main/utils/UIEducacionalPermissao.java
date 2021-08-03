package com.example.fivecontacts.main.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public  class UIEducacionalPermissao extends DialogFragment {

    String mensagem;
    String titulo;
    int codigo;
    public UIEducacionalPermissao(String mensagem, String titulo, int codigo){
        this.mensagem = mensagem;
        this.titulo = titulo;
        this.codigo = codigo;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(this.mensagem)
                .setTitle(this.titulo);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
                listener.onDialogPositiveClick(codigo);
            }
        });
        AlertDialog adialog = builder.create();
        return adialog;
    }

    public interface NoticeDialogListener {
        public void onDialogPositiveClick(int codigo);

    }

    NoticeDialogListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (NoticeDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement NoticeDialogListener");
        }
    }
}
