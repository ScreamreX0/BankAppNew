package com.example.bankappnew.menu.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bankappnew.R;
import com.example.bankappnew._pojo.items;
import com.example.bankappnew.menu.IMenuItems;

public class CardsAdapter extends ArrayAdapter<IMenuItems> {
    Context context;
    IMenuItems[] items;

    public CardsAdapter(@NonNull Context context, int resource, IMenuItems[] objects) {
        super(context, resource, objects);
        this.context = context;
        this.items = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (items[position].getType() == 0) {           // Header
            view = layoutInflater.inflate(R.layout.item_menu_header, parent, false);
            com.example.bankappnew._pojo.items.MenuHeader item = (items.MenuHeader) items[position];

            ((TextView) view.findViewById(R.id.i_menu_text)).setText(item.getHeader());

        } else if (items[position].getType() == 1) {    // Card
            view = layoutInflater.inflate(R.layout.item_menu_cards, parent, false);
            com.example.bankappnew._pojo.items.Card item = (com.example.bankappnew._pojo.items.Card) items[position];

            ((TextView) view.findViewById(R.id.i_menu_card_number)).setText(item.getCardNumber(true));
            ((ImageView) view.findViewById(R.id.i_menu_card_iv)).setImageResource(item.getIcon());
            ((TextView) view.findViewById(R.id.i_menu_card_money)).setText(item.getMoney());

        } else if (items[position].getType() == 2) {    // Account
            view = layoutInflater.inflate(R.layout.item_menu_accounts, parent, false);
            com.example.bankappnew._pojo.items.Account item = (com.example.bankappnew._pojo.items.Account) items[position];

            ((TextView) view.findViewById(R.id.i_menu_account_number)).setText(item.getAccountNumber(true));
            ((TextView) view.findViewById(R.id.i_menu_account_money)).setText(item.getMoney());

        } else {                                        // Credit
            view = layoutInflater.inflate(R.layout.item_menu_credits, parent, false);
            items.Credit item = (com.example.bankappnew._pojo.items.Credit) items[position];

            ((TextView) view.findViewById(R.id.i_menu_credit_payment_date)).setText(item.getPaymentDate());
            ((TextView) view.findViewById(R.id.i_menu_credit_money)).setText(item.getMoney());
        }

        return view;
    }
}
