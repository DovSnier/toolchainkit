#if (${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.dvsnier.base.holder.BaseViewHolder;

#parse("MVP File Header.java")
public class ${NAME} extends BaseViewHolder<${Bean_Name}> {

    protected ${OnClickListener_Name} onClickListener;

    public ${NAME}(@NonNull View itemView) {
        super(itemView);
//      ButterKnife.bind(this, itemView);
    }

    public ${NAME}(@NonNull Context context, int LayoutId, ViewGroup parent) {
        super(context, LayoutId, parent);
//	    ButterKnife.bind(this, itemView);
    }

    @Override
    public void onBindViewHolder(Context context, int position, ${Bean_Name} bean) {
        super.onBindViewHolder(context, position, bean);
		// TODO: ${DATE}
    }

        @Override
    public void setOnClickListener(IBaseOnClickListener onClickListener) {
        if (null != onClickListener && onClickListener instanceof ${OnClickListener_Name}) {
            super.setOnClickListener(onClickListener);
            this.onClickListener = (${OnClickListener_Name}) onClickListener;
        }
    }
}
