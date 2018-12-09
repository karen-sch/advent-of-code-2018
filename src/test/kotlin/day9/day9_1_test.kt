package day9

import org.junit.Assert
import org.junit.Test

class day9_1_test {

    @Test
    fun findWinningElfsScoreTest() {
        Assert.assertEquals(32, findWinningElfsScore(9, 25))
        Assert.assertEquals(8317, findWinningElfsScore(10, 1618))
        Assert.assertEquals(146373, findWinningElfsScore(13, 7999))
        Assert.assertEquals(2764, findWinningElfsScore(17, 1104))
        Assert.assertEquals(54718, findWinningElfsScore(21, 6111))
        Assert.assertEquals(37305, findWinningElfsScore(30, 5807))
    }
}