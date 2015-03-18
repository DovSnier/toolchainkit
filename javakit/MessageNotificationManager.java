/**
 * Filename:    MessageNotificationManager.java   
 * Copyright:   Copyright (c)2014  
 * Company:     DovSnier
 *
 * Create at:   2015-2-6 上午11:42:24   
 * 
 * Description:  
 * 
 *  
 * 
 * Modification History:   
 * 
 *       Date        Author      Version     Description   
 * 
 * ----------------------------------------------------------------- 
 * 
 *     2015-2-6     lzw      1.0.0      1.0.0 Version   
 * 
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import android.util.Log;

/**
 * 
 * @ClassName: MessageNotificationManager
 * @author lzw
 * @date 2015-2-6 上午11:42:24
 * @description This is a description relationship observed & observer a message manager,At this point, we notice the key associated observer and listener. <br>
 *              <h3>The model execution process is as follows</h3>
 * 
 *              <ol>
 *              <li>observable invoke bind.</li>
 *              <li>observer invoke register.</li>
 *              <li>observer invoke add listener</li>
 *              <li>observable invoke notifyDataSetChanged,introduced into the method of parameter</li>
 *              <li>observer to realize the mi interface functions,invoke notifySchon callback</li>
 *              </ol>
 */
public class MessageNotificationManager {

	protected static final String TAG = "MessageNotificationManager";
	private static MessageNotificationManager manager = null;
	private Object current_object = null; // Observable
	private Map<String, Object> observerContainer = new HashMap<String, Object>(); // Observer Container
	private Map<String, UserReadStatusListener> observerListenerContainer = new HashMap<String, UserReadStatusListener>(); // Observer Listener Container

	public static MessageNotificationManager getInstance() {
		if (null == manager) {
			manager = new MessageNotificationManager();
		}
		return manager;
	}

	/**
	 * 
	 * @author lzw
	 * @date 2015-2-6 上午11:47:50
	 * @version v1.0.0
	 * @param object
	 *            observable object
	 * @description binded to Observable(Message Managers hold objects observed)
	 */
	public void bindObservable(Object object) {
		current_object = object;
	}

	/**
	 * 
	 * @author lzw
	 * @date 2015-2-6 上午11:55:01
	 * @version v1.0.0
	 * @description clean up the Observer Container
	 */
	public void clear() {
		if (null != observerContainer && observerContainer.size() > 0) {
			observerContainer.clear();
		}
	}

	/**
	 * @author lzw
	 * @date 2015-2-6 下午1:57:50
	 * @version v1.0.0
	 * @description Reset the observer container
	 */
	public void resetContainer() {
		if (null != observerContainer && observerContainer.size() > 0) {
			observerContainer.clear();
		}
		if (null != observerListenerContainer && observerListenerContainer.size() > 0) {
			observerListenerContainer.clear();
		}
	}

	/**
	 * @author lzw
	 * @date 2015-2-6 下午1:01:54
	 * @version v1.0.0
	 * @param name
	 *            Observer name
	 * @description remove observer that is from observer container
	 */
	public void removeObserver(String name) {
		if (observerContainer.containsKey(name)) {
			Set<Entry<String, Object>> entrySet = observerContainer.entrySet();
			Iterator<Entry<String, Object>> iterator = entrySet.iterator();
			Entry<String, Object> entryObj = null;
			while (iterator.hasNext()) {
				entryObj = iterator.next();
				if (entryObj.getKey().equals(name)) {
					iterator.remove(); // delete observer
				}
			}
		} else {
			Log.w(TAG, "the current observer Container is not contain " + name + " entry object");
		}
	}

	/**
	 * @author lzw
	 * @date 2015-2-6 下午1:12:37
	 * @version v1.0.0
	 * @param observerName
	 *            observer name
	 * @param object
	 *            Object
	 * @description register observer listener
	 */
	public void register(String observerName, Object object) {
		if (observerContainer.containsKey(observerName)) {
			observerContainer.remove(observerName);
		}
		observerContainer.put(observerName, object); // register observer
	}

	/**
	 * @author lzw
	 * @date 2015-2-6 下午1:15:10
	 * @version v1.0.0
	 * @param observerName
	 *            observer name
	 * @param ursListener
	 * @description Add the listener to the observer
	 */
	public void addListener(String observerName, UserReadStatusListener ursListener) {
		if (observerListenerContainer.containsKey(observerName)) {
			observerListenerContainer.remove(observerName);
		}
		observerListenerContainer.put(observerName, ursListener); // register observer listener
	}

	/**
	 * 
	 * 
	 * @author lzw
	 * @date 2015-2-6 下午1:20:39
	 * @version v1.0.0
	 * @param id
	 *            vo id(Pay attention to is not position, but bean id)
	 * @description Notice to observer data changed, request to refresh the view
	 */
	public void notifyDataSetChanged(final String id) {
		if (null == current_object) {
			throw new RuntimeException("You don't have to be the observer with the message manager binding, the observer is null");
		}
		if (null != observerListenerContainer && observerListenerContainer.size() > 0) {
			if (observerContainer.size() != observerListenerContainer.size()) {
				Log.w(TAG, "The container have not yet registered in the observer");
			}
			Iterator<Entry<String, UserReadStatusListener>> iterator = observerListenerContainer.entrySet().iterator();
			Entry<String, UserReadStatusListener> entryObject = null;
			while (iterator.hasNext()) {
				entryObject = iterator.next();
				if (null != entryObject.getValue()) {
					entryObject.getValue().notifySchon(id);
				} else {
					Log.e(TAG, "The current UserReadStatusListener interface instance is null");
				}
			}
		}

	}

	/**
	 * <pre><b>View change notice to observer interface
	 */
	public static interface UserReadStatusListener {
		/** <pre><b>already status */
		public static final int READED = 1;
		/** <pre><b>unread status */
		public static final int UNREAD = 0;

		/**
		 * 
		 * @author lzw
		 * @date 2015-2-6 上午11:19:16
		 * @version v1.0.0
		 * @param id
		 *            vo Id array
		 * @description noticed already readed
		 */
		public abstract void notifySchon(String... id);
	}
}
