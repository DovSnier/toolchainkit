import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * <pre>
 * ObservableScrollView
 * </pre>
 * 
 * @author dovsnier
 * @version 1.0.0
 * @since jdk 1.7
 */
public class ObservableScrollView extends ScrollView {

	private OnScrollViewListener scrollViewListener = null;

	public ObservableScrollView(Context context) {
		super(context);
	}

	public ObservableScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ObservableScrollView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public void setOnScrollViewListener(OnScrollViewListener scrollViewListener) {
		this.scrollViewListener = scrollViewListener;
	}

	@Override
	protected void onScrollChanged(int x, int y, int oldx, int oldy) {
		super.onScrollChanged(x, y, oldx, oldy);
		if (scrollViewListener != null) {
			scrollViewListener.onScrollChanged(this, x, y, oldx, oldy);
		}
	}

	/**
	 * 
	 * <pre>
	 * OnScrollViewListener
	 * </pre>
	 * 
	 * @author dovsnier
	 * @version 1.0.0
	 * @since jdk 1.7
	 */
	public interface OnScrollViewListener {

		/**
		 * 
		 * monitor observable scroll view roll change<br>
		 * 2015-4-15
		 * 
		 * @version 0.0.1
		 * @param scrollView
		 *            {@link ObservableScrollView}
		 * @param x
		 *            the current x axis coordinates
		 * @param y
		 *            the current y axis coordinates
		 * @param oldx
		 *            the older x axis coordinates
		 * @param oldy
		 *            the older y axis coordinates
		 */
		public abstract void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy);
	}
}