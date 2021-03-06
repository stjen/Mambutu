package mambutu;

import mambutu.Plugins.BarHandler;
import mambutu.Handler.MessageDistributor;
import mambutu.Plugins.BugHandler;
import mambutu.Plugins.WeatherHandler;

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
public class Main {
    public static void main(String[] args) {
        Controller c = new Controller();
        MessageDistributor messageDistributor = c.getBot().getMessageDistributor();
        new BarHandler(messageDistributor);
        new WeatherHandler(messageDistributor);
        new BugHandler(messageDistributor);
    }
}
