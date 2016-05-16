import java.util.*;
import java.io.*;
public class BoraBora {
	static String suits = "CDHS";
	static int P, M, N;
	public static void main(String...thegame) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			P = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken()); if(P == 0) return;
			ArrayList<Card> deck = new ArrayList<>();
			for(int i = 0; i < N; i++){
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken())-1;
				String s = st.nextToken();
				deck.add(new Card(r,suits.indexOf(s)));
			}
			ArrayList<Card>[] hands = new ArrayList[P];
			for(int p = 0; p < P; p++){
				hands[p] = new ArrayList<>();
				for(int c = 0; c < M; c++){
					hands[p].add(deck.remove(0));
				}
			}
			Stack<Card> pile = new Stack<>();
			pile.push(deck.remove(0));
			int dir = pile.peek().rank == 11 ? -1 : 1;
			int penalty = -1;
			if(pile.peek().rank == 6) penalty = 2;
			if(pile.peek().rank == 0) penalty = 1;
			if(pile.peek().rank == 10) penalty = 0;
			int curr = 0;
			for(;;curr=(curr+dir+P)%P){
				if(penalty >= 0){
					for(int i = 0; i < penalty; i++){
						hands[curr].add(deck.remove(0));
					}
					penalty = -1;
				}
				else{
					Card played = null;
					for(int _try = 0; _try < 2; _try++){
						Collections.sort(hands[curr]);
						for(Card c: hands[curr]){
							if(pile.peek().rank == c.rank || pile.peek().suit == c.suit){
								played = c; break;
							}
						}
						if(played != null) break;
						else if(_try < 1) hands[curr].add(deck.remove(0));
					}
					if(played == null) continue;
					hands[curr].remove(played);
					if(hands[curr].size() == 0) break;
					pile.push(played);
					if(played.rank == 6) penalty = 2;
					if(played.rank == 0) penalty = 1;
					if(played.rank == 10) penalty = 0;
					if(played.rank == 11) dir = -dir;
				}
			}
			System.out.println(curr+1);
		}
	}
	static class Card implements Comparable<Card>{
		int rank, suit;
		public Card(int r, int s){
			rank = r; suit = s;
		}
		@Override
		public int compareTo(Card o) {
			return  (o.rank - rank)*4 + (o.suit - suit);	
		}
		public String toString(){
			return rank + " " + suits.charAt(suit);
		}
	}
}
