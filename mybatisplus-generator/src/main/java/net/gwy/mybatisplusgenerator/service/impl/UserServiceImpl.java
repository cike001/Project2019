package net.gwy.mybatisplusgenerator.service.impl;

import net.gwy.mybatisplusgenerator.model.User;
import net.gwy.mybatisplusgenerator.mapper.UserMapper;
import net.gwy.mybatisplusgenerator.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author guoweiyang
 * @since 2019-07-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
