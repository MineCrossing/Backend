package xyz.minecrossing.backend.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import xyz.minecrossing.backend.database.MineCrossingDB;

@RestController
public class PlayersAPIController implements PlayersAPI {

    /*@Override
    public ResponseEntity<Object> players() {
        HashMap<String, Object> players = new HashMap<>();

        try (Connection con = DatabaseConnector.getInstance().getConnection("minecrossing")) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM players;");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HashMap<String, Object> data = new HashMap<>();
                data.put("name", rs.getString("name"));
                data.put("time", rs.getFloat("time"));
                data.put("level", rs.getInt("level"));
                data.put("kills", rs.getInt("kills"));
                data.put("deaths", rs.getInt("deaths"));
                data.put("wins", rs.getInt("wins"));
                data.put("losses", rs.getInt("losses"));
                data.put("logins", rs.getInt("logins"));
                data.put("quests", rs.getInt("quests"));

                players.put(rs.getString("uuid"), data);
            }

            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(players, HttpStatus.OK);
    }
*/
    @Override
    public ResponseEntity<Object> players() {
        var db = MineCrossingDB.getInstance();
        return new ResponseEntity<>(db.Players.findAll(), HttpStatus.OK);
    }

}
