package mambutu;

import java.io.IOException;
import java.net.Socket;

/**
 * This file is part of Mambutu.
 * <p/>
 * Mambutu is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Mambutu is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with Mambutu.  If not, see <http://www.gnu.org/licenses/>.
 * <p/>
 * <p/>
 * Created by mabool on 11/24/15.
 */
public class Controller {
    Socket socket;
    ReceiverThread rt;
    SenderThread st;
    Bot bot;

    public Bot getBot() {
        return bot;
    }

    public Controller() {
        try {
            socket = new Socket(Config.SERVER_NAME, Config.SERVER_PORT);
            rt = new ReceiverThread(this, socket);
            st = new SenderThread(socket);
            bot = new Bot(this);
            st.start();
            rt.start();
            bot.initConnection();
        } catch (IOException e) {
            System.out.printf("Connection not possible");
        }
    }

    public void sendMessage(String msg) {
        st.output(msg);
    }

    public void newInput(String msg) {
        bot.handleMessage(msg);
    }


}
