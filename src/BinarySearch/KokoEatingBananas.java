package BinarySearch;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int nums[] = {3,6,7,11};
        int h = 8;
        System.out.println("Min eating speed: " + minEatingSpeed(nums,h));
    }

        static int findMaximumElement(int[] piles) {
            int maxi = Integer.MIN_VALUE;
            for(int i=0; i<piles.length; ++i) {
                maxi = Math.max(maxi,piles[i]);
            }
            return maxi;
        }

        static long timeRequiredByKoko(int[] piles,int eatingSpeedPerHr) {
            long hr = 0;
            for(int i=0; i<piles.length; ++i) {
                hr = hr  + (int) (Math.ceil(piles[i] / (double) eatingSpeedPerHr));
            }
            return hr;
        }

        static int minEatingSpeed(int[] piles, int h) {
            int maximumElement = findMaximumElement(piles);
            int low = 1 , high = maximumElement;
            int ans = 0;
            while(low <= high) {
                int mid = (low + high) / 2;
                long hoursKokoRequired =  timeRequiredByKoko(piles,mid);
                if(hoursKokoRequired <= h) {
                    ans = mid;
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            return ans;
        }
    }
