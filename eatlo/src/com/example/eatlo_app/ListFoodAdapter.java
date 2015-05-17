package com.example.eatlo_app;

import java.util.ArrayList;
import java.util.List;







import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ListFoodAdapter extends BaseAdapter {

	
	Context context;
	ViewHolder holder;
	protected List<Food> listFood;
	static List<Cart> c=new ArrayList<Cart>();
	LayoutInflater inflater;
	TextView tx;
	int s=0;
	int pos;
	
	int id=0;
	
	public ListFoodAdapter(Context context, List<Food> listFood) {
		this.listFood = listFood;
		this.inflater = LayoutInflater.from(context);
		this.context = context;
		
	}

	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listFood.size();
		
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return listFood.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return listFood.get(position).getDrawableId();
	}

	@Override
	public View getView( int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final ViewHolder holder;
		pos=position;
		if (convertView == null) {

			holder = new ViewHolder();
			convertView = this.inflater.inflate(R.layout.list_item, parent, false);

			holder.title = (TextView) convertView.findViewById(R.id.title);
			holder.price = (TextView) convertView.findViewById(R.id.price);
			holder.imgCar   = (ImageView)convertView.findViewById(R.id.imageView1);
			holder.quant=(TextView)convertView.findViewById(R.id.quan);
			holder.decr=(ImageView)convertView.findViewById(R.id.dec);
			holder.incr=(ImageView)convertView.findViewById(R.id.inc);
			

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		
		
		final Food f = listFood.get(position);
		holder.imgCar.setImageResource(f.getDrawableId());
		holder.title.setText(f.getTitle());
		holder.price.setText("Rs "+f.getPrice());
		holder.quant.setText(f.getQuan()+"");
		
		holder.decr.setImageResource(f.getDecrement());
		holder.incr.setImageResource(f.getIncremenet());
		
		holder.incr.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tx = (TextView) ((Activity)context).findViewById(R.id.prices);
				s+=f.getPrice();
				String sm=Integer.toString(s);
				tx.setText("Rs "+sm);
				
					if(c.size()==0)
					{
						c.add(new Cart( f.getTitle(), f.getPrice()));
						f.incquan();
						holder.quant.setText(f.getQuan()+"");
					}
						else
					{
						int flag=0;
						for(int i=0;i<c.size();++i)
						{
							Cart fs=c.get(i);
							if(fs.getTitlle()==f.getTitle())
							{
								fs.update_quantity();
								f.incquan();
								holder.quant.setText(f.getQuan()+"");
								flag=1;
								break;
							}
						}
						if(flag==0)
						{
							c.add(new Cart( f.getTitle(), f.getPrice()));
							f.incquan();
							holder.quant.setText(f.getQuan()+"");
							
						}
						flag=0;
						
					}
			
				//Toast.makeText(context, ""+c.size(), 0).show();
				//Toast.makeText(context, c.get(1).getTitlle(), 0).show();
			}
		});
		
		
holder.decr.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tx = (TextView) ((Activity)context).findViewById(R.id.prices);
				if(f.getQuan()>0)
				{
				s-=f.getPrice();
				String sm=Integer.toString(s);
				tx.setText("Rs "+sm);
				
					
						
						for(int i=0;i<c.size();++i)
						{
							Cart fs=c.get(i);
							if(fs.getTitlle()==f.getTitle())
							{
								fs.dec_quantity();
								f.decquan();
								holder.quant.setText(f.getQuan()+"");
								if(f.getQuan()==0)
									c.remove(i);
								
								break;
							}
						}
						
						
				//Toast.makeText(context, ""+c.size(), 0).show();
				//Toast.makeText(context, c.get(1).getTitlle(), 0).show();
			}
			}
		});
		
		
		
		
		return convertView;
	}
	
	public static List<Cart> getlist()
	{
		return c;
	}
	private class ViewHolder {
		TextView title;
		TextView price;
		ImageView imgCar;
		TextView quant;
		ImageView decr;
		ImageView incr;
	}

}
