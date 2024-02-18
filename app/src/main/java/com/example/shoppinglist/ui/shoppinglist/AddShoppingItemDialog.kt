package com.example.shoppinglist.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppinglist.data.db.entity.ShoppingItem
import com.example.shoppinglist.databinding.DialogAddShoppingitemBinding

class AddShoppingItemDialog(context: Context, private var addDialogListener: AddDialogListener) :
    AppCompatDialog(context) {
    private val binding by lazy { DialogAddShoppingitemBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {

            tvAdd.setOnClickListener {
                val name = etName.text.toString()
                val amount = etAmount.text.toString()

                if (name.isEmpty() || amount.isEmpty()) {
                    Toast.makeText(context, "Please enter all the information", Toast.LENGTH_SHORT)
                        .show()
                    return@setOnClickListener
                }

                val item = ShoppingItem(name, amount.toInt())
                addDialogListener.onAddButtonClicked(item)
                dismiss()
            }


            tvCancel.setOnClickListener {
                cancel()
            }
        }
    }
}