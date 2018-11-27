import java.util.ArrayList;

public class Mates {

    private boolean inCheck(ArrayList<Piece> checkTeam, ArrayList<Piece> oppTeam, Board b)
    {
        //Check if oppTeam's pieces have valid moves to checkTeam's King Position
        //King will always be at the 0th position of each team's array list
        //Start at 1 because oppTeam's King is at 0 and will never have valid move to checkTeam's King
        for(int i = 1; i < oppTeam.size(); i++)
        {
            if(oppTeam.get(i).validMove(b.board()[checkTeam.get(i).file()][checkTeam.get(i).rank()], b))
            {
                return true;
            }
        }
        return false;
    }


    //Return 2 if check mate, 1 if stale mate, 0 if neither
    public int endGameTest(ArrayList<Piece> checkTeam, ArrayList<Piece> oppTeam, Board b)
    {
        //If we go into this statement and we are in check mate return 4
        //If we go into this statement and we are not in check mate return 3
        if(inCheck(checkTeam, oppTeam, b))
        {
            for(int i = 0; i < checkTeam.size(); i++)
            {
                Board testBoard = new Board(b.board(), b.whitePieces(), b.blackPieces());
                Piece testPiece = checkTeam.get(i);
                if(testPiece.getClass().equals(Pawn.class))
                {
                    if(testPiece.team() == 'W')
                    {
                        //Test additional move
                        if(!testPiece.hasMoved())
                        {
                            if(testPiece.move(testBoard, testBoard.board()[testPiece.file()+2][testPiece.rank()]))
                            {
                                if(!inCheck(checkTeam, oppTeam, testBoard))
                                {
                                    return 3;
                                }
                            }
                        }
                        //Test normal moves
                        if(testPiece.move(testBoard, testBoard.board()[testPiece.file()+1][testPiece.rank()]))
                        {
                            if(!inCheck(checkTeam, oppTeam, testBoard))
                            {
                                return 3;
                            }
                        }
                        if(testPiece.move(testBoard, testBoard.board()[testPiece.file()+1][testPiece.rank()-1]))
                        {
                            if(!inCheck(checkTeam, oppTeam, testBoard))
                            {
                                return 3;
                            }
                        }
                        if(testPiece.move(testBoard, testBoard.board()[testPiece.file()+1][testPiece.rank()+1]))
                        {
                            if(!inCheck(checkTeam, oppTeam, testBoard))
                            {
                                return 3;
                            }
                        }
                    }
                    else
                    {
                        //Test additional move
                        if(!testPiece.hasMoved())
                        {
                            if(testPiece.move(testBoard, testBoard.board()[testPiece.file()-2][testPiece.rank()]))
                            {
                                if(!inCheck(checkTeam, oppTeam, testBoard))
                                {
                                    return 3;
                                }
                            }
                        }
                        //Test normal moves
                        if(testPiece.move(testBoard, testBoard.board()[testPiece.file()-1][testPiece.rank()]))
                        {
                            if(!inCheck(checkTeam, oppTeam, testBoard))
                            {
                                return 3;
                            }
                        }
                        if(testPiece.move(testBoard, testBoard.board()[testPiece.file()-1][testPiece.rank()-1]))
                        {
                            if(!inCheck(checkTeam, oppTeam, testBoard))
                            {
                                return 3;
                            }
                        }
                        if(testPiece.move(testBoard, testBoard.board()[testPiece.file()-1][testPiece.rank()+1]))
                        {
                            if(!inCheck(checkTeam, oppTeam, testBoard))
                            {
                                return 3;
                            }
                        }
                    }
                }
                else if(checkTeam.get(i).getClass().equals(King.class))
                {

                }
                else if(checkTeam.get(i).getClass().equals(Rook.class))
                {

                }
                else if(checkTeam.get(i).getClass().equals(Bishop.class))
                {

                }
                else if(checkTeam.get(i).getClass().equals(Knight.class))
                {

                }
                else if(checkTeam.get(i).getClass().equals(Queen.class))
                {

                }
            }
            return 4;
        }
        //If we go into this statement and get to the end we have stalemate and return 1
        else
        {
            return 1;
        }
        //Neither checkmate or stale mate - add return 0 here when stalemate finished

    }
}
