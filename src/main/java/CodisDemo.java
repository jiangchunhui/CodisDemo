
import io.codis.jodis.JedisResourcePool;
import io.codis.jodis.RoundRobinJedisPool;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;


/**
 * @author wujiang
 * @version 1.0.0
 * @date 2017/7/12
 */
public class CodisDemo {
    public static void main(String[] args) {
        JedisResourcePool jedisPool = RoundRobinJedisPool.create()
                .curatorClient("10.202.94.75:2181", 30000).zkProxyDir("/jodis/codis-wujiang").build();
        //Jedis jedis = new Jedis("10.202.94.16", 6379, 0);
        Jedis jedis = jedisPool.getResource();
        jedis.set("test", "bat1");
        String value = jedis.get("test");
        //jedis.del("test");
        System.out.println(value);



        //Set sentinels = new HashSet();
        //sentinels.add(new HostAndPort("10.202.94.16", 26379).toString());
        //JedisSentinelPool sentinelPool = new JedisSentinelPool("mymaster",
        //        sentinels);
        //Jedis jedis = sentinelPool.getResource();
        //jedis.set("test", "bat1");
        //String value = jedis.get("test");
        ////jedis.del("test");
        //System.out.println(value);
    }
}
