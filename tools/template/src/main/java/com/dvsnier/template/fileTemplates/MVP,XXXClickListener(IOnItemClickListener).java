#if (${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end

import android.view.View;

import com.dvsnier.base.IBaseOnClickListener;

#parse("MVP File Header.java")
public interface ${NAME}<${Bean_Name}> extends IBaseOnClickListener {

    void onXXX(View view, int position, ${Bean_Name} bean);
}
