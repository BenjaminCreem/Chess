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


    public int endGameTest(ArrayList<Piece> checkTeam, ArrayList<Piece> oppTeam, Board b)
    {
        //If we go into this statement and we are in check mate return 3
        //If we go into this statement and we are only in check return 2
        if(inCheck(checkTeam, oppTeam, b))
        {
            if(hasAnyValidMove(checkTeam, oppTeam, b))
            {
                return 2; //Check, not check mate
            }
            else
            {
                return 3; //Check mate
            }
        }
        //If we go into this statement and we cant move we are in stale mate
        //If we go into this statement and we can move we can play as normal
        else
        {
            if(hasAnyValidMove(checkTeam, oppTeam, b))
            {
                return 0; //We have a valid move, we are not in stale mate
            }
            else
            {
                return 1; //We have no valid moves but we are not in check so we are in stale mate
            }
        }
        //Neither checkmate or stale mate - add return 0 here when stalemate finished
    }

    private boolean hasAnyValidMove(ArrayList<Piece> checkTeam, ArrayList<Piece> oppTeam, Board b)
    {
        for(int i = 0; i < checkTeam.size(); i++)
        {
            Board testBoard = new Board(b.board(), b.whitePieces(), b.blackPieces());
            Piece testPiece = checkTeam.get(i);
            if(testPiece.getClass().equals(Pawn.class) && pawnMoveTest(testPiece, testBoard, checkTeam, oppTeam))
            {
                return true;
            }
            else if(testPiece.getClass().equals(King.class) && kingMoveTest(testPiece, testBoard, checkTeam, oppTeam))
            {
                return true;
            }
            else if(testPiece.getClass().equals(Queen.class) && queenMoveTest(testPiece, testBoard, checkTeam, oppTeam))
            {
                return true;
            }
            else if(testPiece.getClass().equals(Rook.class) && rookMoveTest(testPiece, testBoard, checkTeam, oppTeam))
            {
                return true;
            }
            else if(testPiece.getClass().equals(Bishop.class) && bishopMoveTest(testPiece, testBoard, checkTeam, oppTeam))
            {
                return true;
            }
            else if(testPiece.getClass().equals(Knight.class) && knightMoveTest(testPiece, testBoard, checkTeam, oppTeam))
            {
                return true;
            }
        }
        return false;
    }

    private boolean pawnMoveTest(Piece tp, Board tb, ArrayList<Piece> ct, ArrayList<Piece> ot)
    {
        if(tp.team() == 'W')
        {
            //Test additional move
            if(!tp.hasMoved())
            {
                if(tp.move(tb, tb.board()[tp.file()+2][tp.rank()]))
                {
                    if(!inCheck(ct, ot, tb))
                    {
                        return true;
                    }
                }
            }
            //Test normal moves
            if(tp.move(tb, tb.board()[tp.file()+1][tp.rank()]))
            {
                if(!inCheck(ct, ot, tb))
                {
                    return true;
                }
            }
            if(tp.move(tb, tb.board()[tp.file()+1][tp.rank()-1]))
            {
                if(!inCheck(ct, ot, tb))
                {
                    return true;
                }
            }
            if(tp.move(tb, tb.board()[tp.file()+1][tp.rank()+1]))
            {
                if(!inCheck(ct, ot, tb))
                {
                    return true;
                }
            }
        }
        else
        {
            //Test additional move
            if(!tp.hasMoved())
            {
                if(tp.move(tb, tb.board()[tp.file()-2][tp.rank()]))
                {
                    if(!inCheck(ct, ot, tb))
                    {
                        return true;
                    }
                }
            }
            //Test normal moves
            if(tp.move(tb, tb.board()[tp.file()-1][tp.rank()]))
            {
                if(!inCheck(ct, ot, tb))
                {
                    return true;
                }
            }
            if(tp.move(tb, tb.board()[tp.file()-1][tp.rank()-1]))
            {
                if(!inCheck(ct, ot, tb))
                {
                    return true;
                }
            }
            if(tp.move(tb, tb.board()[tp.file()-1][tp.rank()+1]))
            {
                if(!inCheck(ct, ot, tb))
                {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean kingMoveTest(Piece tp, Board tb, ArrayList<Piece> ct, ArrayList<Piece> ot)
    {
        //Test square around king
        for(int j = -1; j < 2; j++)
        {
            for(int k = -1; k < 2; k++)
            {
                if(j != 0 && k != 0 && tp.move(tb, tb.board()[tp.file()+j][tp.rank()+k]))
                {
                    if(!inCheck(ct, ot, tb))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean queenMoveTest(Piece tp, Board tb, ArrayList<Piece> ct, ArrayList<Piece> ot)
    {
        //Queen moves are just both the rook and the bishop so we can borrow their methods
        if(rookMoveTest(tp, tb, ct, ot) || bishopMoveTest(tp, tb, ct, ot))
        {
            return true;
        }
        return false;
    }

    private boolean rookMoveTest(Piece tp, Board tb, ArrayList<Piece> ct, ArrayList<Piece> ot)
    {
        //Test forward and backward
        for(int j = tp.rank()+1; j < 8; j++)
        {
            if(tp.move(tb, tb.board()[tp.file()][tp.rank()+j]))
            {
                if(!inCheck(ct, ot, tb))
                {
                    return true;
                }
            }
        }
        for(int j = tp.rank()-1; j > 0; j--)
        {
            if(tp.move(tb, tb.board()[tp.file()][tp.rank()+j]))
            {
                if(!inCheck(ct, ot, tb))
                {
                    return true;
                }
            }
        }
        //Test side to side
        for(int j = tp.file()-1; j >= 'a'; j--)
        {
            if(tp.move(tb, tb.board()[tp.file()+j][tp.rank()]))
            {
                if(!inCheck(ct, ot, tb))
                {
                    return true;
                }
            }
        }
        for(int j = tp.file()-1; j <= 'h'; j++)
        {
            if(tp.move(tb, tb.board()[tp.file()+j][tp.rank()]))
            {
                if(!inCheck(ct, ot, tb))
                {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bishopMoveTest(Piece tp, Board tb, ArrayList<Piece> ct, ArrayList<Piece> ot)
    {
        return false;
    }

    private boolean knightMoveTest(Piece tp, Board tb, ArrayList<Piece> ct, ArrayList<Piece> ot)
    {
        return false;
    }
}



































