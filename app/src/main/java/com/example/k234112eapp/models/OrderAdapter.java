package com.example.models;

import static com.example.models.OrderStatus.COMPLETED;
import static com.example.models.OrderStatus.CUSTOMER_COMPLAIN;
import static com.example.models.OrderStatus.NOT_PAYMENT;
import static com.example.models.OrderStatus.ON_LOGISTIC;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.k234112eappmobile.R;


public class OrderAdapter extends ArrayAdapter<Order> {
    Activity context;
    int resource;

    public OrderAdapter(@NonNull Activity context, int resource)
    {
        super(context,resource);

        this.context=context;
        this.resource=resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View custom=inflater.inflate(resource,null);
        Order order=getItem(position);
        TextView txtOrderId=custom.findViewById(R.id.txtOrderId);
        TextView txtOrderDate=custom.findViewById(R.id.txtOrderDate);
        TextView txtStatus=custom.findViewById(R.id.txtStatus);
        TextView txtOrderTotal=custom.findViewById(R.id.txtOrderTotal);
        txtOrderId.setText(order.getOrderId().toString());
        txtOrderDate.setText(order.getOrderDate().toString());
        switch (order.getOrderStatus())
        {
            case COMPLETED:
                txtStatus.setText(context.getString(R.string.str_order_status_completed));
                break;
            case NOT_PAYMENT:
                txtStatus.setText(context.getString(R.string.str_order_status_not_payment));
                break;
            case ON_LOGISTIC:
                txtStatus.setText(context.getString(R.string.str_order_status_on_logistic));
                break;
            case CUSTOMER_COMPLAIN:
                txtStatus.setText(context.getString(R.string.str_order_status_customer_complain));
                break;
        }
        txtOrderTotal.setText(DataWareHouse.sumOfMoney(order)+"VND");
        return custom;
    }
}