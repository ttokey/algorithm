package programmers.practice.lv2;

public class DeliveryAndPickUp_150369 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        Truck truck = new Truck(cap, deliveries, pickups);
        return truck.getMinDistance();
    }

    public class Truck {
        int cap;
        int maxDelivery;
        int maxPickUp;
        int[] deliveries;
        int[] pickups;

        public Truck(int cap, int[] deliveries, int[] pickups) {
            this.cap = cap;
            this.deliveries = deliveries;
            this.pickups = pickups;
            this.maxDelivery = deliveries.length - 1;
            this.maxPickUp = pickups.length - 1;
        }

        public long getMinDistance() {
            long result = 0;
            while (maxDelivery >= 0 || maxPickUp >= 0) {
                result += getMoveDistance();
            }
            return result;
        }

        private long getMoveDistance() {
            int deliveryCap = cap;
            int pickupCap = cap;

            for (int i = maxDelivery; i >= 0; i--) {
                if (deliveries[i] != 0) {
                    maxDelivery = i;
                    break;
                }
                if (i == 0 && deliveries[i] == 0) {
                    maxDelivery = -1;
                }
            }

            for (int i = maxPickUp; i >= 0; i--) {
                if (pickups[i] != 0) {
                    maxPickUp = i;
                    break;
                }
                if (i == 0 && pickups[i] == 0) {
                    maxPickUp = -1;
                }
            }

            for (int i = maxDelivery; i >= 0 && deliveryCap > 0; i--) {
                if (deliveries[i] > deliveryCap) {
                    deliveries[i] -= deliveryCap;
                    break;
                } else {
                    deliveryCap -= deliveries[i];
                    deliveries[i] = 0;
                }
            }

            for (int i = maxPickUp; i >= 0 && pickupCap > 0; i--) {
                if (pickups[i] > pickupCap) {
                    pickups[i] -= pickupCap;
                    break;
                } else {
                    pickupCap -= pickups[i];
                    pickups[i] = 0;
                }
            }

            return (long) (Math.max(maxDelivery, maxPickUp) + 1) * 2;
        }
    }
}
