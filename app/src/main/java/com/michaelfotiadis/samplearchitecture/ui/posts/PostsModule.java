package com.michaelfotiadis.samplearchitecture.ui.posts;

import com.michaelfotiadis.samplearchitecture.db.dao.PostDao;
import com.michaelfotiadis.samplearchitecture.domain.GetAllPostsUseCase;
import com.michaelfotiadis.samplearchitecture.domain.mapper.PostsMapper;
import com.michaelfotiadis.samplearchitecture.net.MainRepository;
import com.michaelfotiadis.samplearchitecture.ui.common.intent.IntentDispatcher;

import dagger.Module;
import dagger.Provides;

@Module()
public class PostsModule {

    @Provides
    IntentDispatcher providesIntentDispatcher(PostsActivity activity) {
        return new IntentDispatcher(activity);
    }

    @Provides
    PostsMapper providesPostsMapper() {
        return new PostsMapper();
    }

    @Provides
    GetAllPostsUseCase providesPostsUseCase(MainRepository mainRepository,
                                            PostDao postModel,
                                            PostsMapper mapper) {
        return new GetAllPostsUseCase(mainRepository, postModel, mapper);
    }


}
