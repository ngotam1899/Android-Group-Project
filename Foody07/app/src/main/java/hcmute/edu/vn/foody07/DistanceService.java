package hcmute.edu.vn.foody07;

public class DistanceService {

    static final double _eQuatorialEarthRadius = 6378.1370;
    static final double _d2r = (Math.PI / 180);

    public double HaversineInKM(double lat1, double long1, double lat2, double long2) {
        lat1=lat1*_d2r;
        long1=long1*_d2r;
        lat2=lat2*_d2r;
        long2=long2*_d2r;
        double distance=_eQuatorialEarthRadius*Math.acos((Math.sin(lat1) * Math.sin(lat2)) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(long2-long1));
        return distance;
    }
}
