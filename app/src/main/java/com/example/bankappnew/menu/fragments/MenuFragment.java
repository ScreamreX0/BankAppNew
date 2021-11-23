package com.example.bankappnew.menu.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bankappnew.R;
import com.example.bankappnew._pojo.items;
import com.example.bankappnew.menu.IMenuItems;
import com.example.bankappnew.menu.adapters.CardsAdapter;

public class MenuFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        CardsAdapter cardsAdapter = new CardsAdapter(getContext(), 0, new IMenuItems[] {
                new items.MenuHeader("МОИ КАРТЫ"),
                new items.Card(R.mipmap.ic_mastercard, "1234567812345678", "321"),
                new items.Card(R.mipmap.ic_mir, "2234567812345677", "123"),
                new items.Card(R.mipmap.ic_mastercard, "3234567812345676", "222"),
                new items.Card(R.mipmap.ic_mir, "4234567812345675", "4234"),
                new items.Card(R.mipmap.ic_mastercard, "5234567812345674", "41214"),
                new items.MenuHeader("МОИ СЧЕТА"),
                new items.Account("1234567890", "32131"),
                new items.Account("2234567890", "31451"),
                new items.Account("3234567890", "6632"),
                new items.Account("4234567890", "2634"),
                new items.Account("5234567890", "2342"),
                new items.MenuHeader("МОИ КРЕДИТЫ"),
                new items.Credit("22.11.2021", "123"),
                new items.Credit("23.11.2021", "1234"),
                new items.Credit("24.11.2021", "3213"),
                new items.Credit("25.11.2021", "124"),
                new items.Credit("26.11.2021", "5345")
        });

        View view = inflater.inflate(R.layout.f_cards, container, false);
        ((ListView)view.findViewById(R.id.f_cards)).setAdapter(cardsAdapter);

        return view;
    }
}
