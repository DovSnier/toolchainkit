#if (${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.dvsnier.base.adapter.BaseRecyclerViewAdapter;

import java.util.List;

#parse("MVP File Header.java")
public class ${NAME} extends BaseRecyclerViewAdapter<${Bean_Name}, RecyclerView.ViewHolder> {

    public ${NAME}() {
    }

    public ${NAME}(@NonNull Context context, List<${Bean_Name}> data) {
        super(context, data);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
	// TODO: ${DATE} 
	if (viewType == TYPE_XXX) {
            return new XXXViewHolder(getContext(), R.layout.layout_view_holder_xxx, parent);
        } else if (viewType == TYPE_ITEM_YYY) {
            return new YYYViewHolder(getContext(), R.layout.layout_view_holder_yyy, parent);
        }else {
			// nothing to do
		}
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        if (null != holder) {
            ${Bean_Name} item = getItem(position);
		    // TODO: ${DATE} 
            if (holder instanceof XXX) {
                ((XXX) holder).setOnClickListener(getOnClickListener());
                ((XXX) holder).onBindViewHolder(getContext(), position, item);
            } else if (holder instanceof YYY) {
                ((YYY) holder).setOnClickListener(getOnClickListener());
                ((YYY) holder).onBindViewHolder(getContext(), position, item);
            } else {
                // nothing to do
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        ${Bean_Name} item = getItem(position);
        if (null != item) {
			// TODO: ${DATE} 
			return item.getItemType().ordinal();
        }
        return super.getItemViewType(position);
    }
}
